package util;

import demo.modelo.EmpleadoDTO;
import org.hibernate.HibernateException;
import org.hibernate.SessionFactory;
import org.hibernate.Session;
import org.hibernate.Transaction;

import java.sql.Timestamp;
import java.util.List;

import static demo.driver.EmpleadoControlador.ssf;

public class Empleado extends EmpleadoDTO{


    public void listEmployees(){
        Session session = ssf.openSession();
        Transaction tx = null;

        try {
            tx = session.beginTransaction();
            List<EmpleadoDTO> empleadoDTOList = session.createQuery("FROM EmpleadoDTO", EmpleadoDTO.class).getResultList();
            for (EmpleadoDTO empleado : empleadoDTOList) {
                System.out.println("ID: " + empleado.getId() + ", Name: " + empleado.getName() + ", LastName: " + empleado.getLastname() + ", CreatedAt: " + empleado.getCreated_at());
            }
            tx.commit();
        }catch (HibernateException ex){
            if(tx!=null)    tx.rollback();
            ex.printStackTrace();
        }finally {
            session.close();
        }
    }

    public Long add(String name, String lastName){
        Session session = ssf.openSession();
        Transaction tx = null;
        Long flag = null;
        try {
            tx = session.beginTransaction();
            EmpleadoDTO empleadoDTO = new EmpleadoDTO(name, lastName, new Timestamp(System.currentTimeMillis()));
            flag = (Long)session.save(empleadoDTO);
            tx.commit();
        }catch (HibernateException ex){
            if(tx != null)  tx.rollback();
            ex.printStackTrace();
        }finally {
            session.close();
        }
        return flag;
    }
    public void updateName(Long id, String name){
        Session session = ssf.openSession();
        Transaction tx =  null;

        try {
            tx = session.beginTransaction();
            EmpleadoDTO empleadoDTO = (EmpleadoDTO) session.get(EmpleadoDTO.class, id);
            empleadoDTO.setName(name);
            session.update(empleadoDTO);
            tx.commit();
        }catch (HibernateException ex){
            if(tx != null)  tx.rollback();
            ex.printStackTrace();
        }finally {
            session.close();
        }
    }

    public void updateLastName(Long id, String lastName){
        Session session = ssf.openSession();
        Transaction tx =  null;

        try {
            tx = session.beginTransaction();
            EmpleadoDTO empleadoDTO = (EmpleadoDTO) session.get(EmpleadoDTO.class, id);
            empleadoDTO.setLastname(lastName);
            session.update(empleadoDTO);
            tx.commit();
        }catch (HibernateException ex){
            if(tx != null)  tx.rollback();
            ex.printStackTrace();
        }finally {
            session.close();
        }
    }

    public void deleteEmpleado(Long id){
        Session session = ssf.openSession();
        Transaction tx =  null;

        try {
            tx = session.beginTransaction();
            EmpleadoDTO empleadoDTO = (EmpleadoDTO) session.get(EmpleadoDTO.class, id);
            session.delete(empleadoDTO);
            tx.commit();
        }catch (HibernateException ex){
            if(tx != null)  tx.rollback();
            ex.printStackTrace();
        }finally {
            session.close();
        }
    }
}
