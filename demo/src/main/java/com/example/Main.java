package com.example;
import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

import com.example.Entidad.Cliente;

public class Main {
    private static EntityManagerFactory emf = Persistence.createEntityManagerFactory("miUnidadPersistencia");

    public static void main(String[] args) {
        EntityManager em = emf.createEntityManager();

        // crearCliente("Kathe", "Kathe@gmail.com", 2897569);

        Cliente cliente = leerCliente(1L);
        if (cliente != null) {
            System.out.println("Cliente encontrado: " + cliente.getNombre());
        }

        em.close();
        emf.close();
    }

    // public static void crearCliente (String nombre, String correo, int telefono){
    //     EntityManager em = emf.createEntityManager();
    //     em.getTransaction().begin();

    //     Cliente clienteUno = new Cliente();
    //     clienteUno.setNombre(nombre);
    //     clienteUno.setCorreo(correo);
    //     clienteUno.setTelefono(telefono);

    //     em.persist(clienteUno);

    //     em.getTransaction().commit();
    //     em.close();
    // }

    public static Cliente leerCliente(long id){
        EntityManager em = emf.createEntityManager();
        Cliente cliente = em.find(Cliente.class, id);
        em.close();
        return cliente;
    }
}