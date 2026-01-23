package cafetera.tests;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;

import cafetera.recursos.Cafetera;

class CafeteraTests {

	/**
	 * Test del primer constructor. Este crea una cafetera vacía con una capacidad
	 * máxima de 1000cc
	 */
	@Test
	void testConstructor1() {
		Cafetera c = new Cafetera();
		assertEquals(1000, c.getCapacidadMaxima());
		assertEquals(0, c.getCantidadActual());
	}
	
	/**
	 * Test del segundo constructor. Este crea una cafetera llena con una capacidad
	 * máxima introducida como parámetro
	 */
	@Test
	void testConstructor2() {
		int capacidad = 3000;
		Cafetera c = new Cafetera(capacidad);
		assertEquals(capacidad, c.getCapacidadMaxima());
		assertEquals(c.getCapacidadMaxima(), c.getCantidadActual());
	}
	
	/**
	 * Test del tercer constructor. Este crea una cafetera con una capacidad
	 * máxima y cantidad introducidas como parámetros
	 */
	@Test
	void testConstructor3() {
		int capacidad = 3000;
		int cantidad = 400;
		Cafetera c = new Cafetera(capacidad, cantidad);
		assertEquals(capacidad, c.getCapacidadMaxima());
		assertEquals(cantidad, c.getCantidadActual());
	}
	
	/**
	 * Prueba del setter y getter de capacidad de la cafetera
	 */
	@Test
	void testMetodoSetYGetCapacidad() {
		int capacidadEsperada = 2500;
		Cafetera c = new Cafetera();
		c.setCapacidadMaxima(capacidadEsperada);
		assertEquals(capacidadEsperada, c.getCapacidadMaxima());
	}
	
	/**
	 * Debido a que no se ha hecho manejo de excepciones en el método, se
	 * permite asignar una capacidad máxima negativa a la cafetera. Esto NO
	 * debería ser posible
	 */
	@Test
	void testMetodoSetYGetCapacidadNegativa() {
		int capacidadEsperada = -1000;
		Cafetera c = new Cafetera();
		c.setCapacidadMaxima(capacidadEsperada);
		assertEquals(capacidadEsperada, c.getCapacidadMaxima());
	}
	
	/**
	 * Prueba del setter y getter de cantidad de la cafetera
	 */
	@Test
	void testMetodoSetYGetCantidad() {
		int cantidadEsperada = 400;
		Cafetera c = new Cafetera();
		c.setCantidadActual(cantidadEsperada);
		assertEquals(cantidadEsperada, c.getCantidadActual());
	}
	
	/**
	 * Debido a que no se ha hecho manejo de excepciones en el método, se
	 * permite asignar una cantidad negativa a la cafetera. Esto NO
	 * debería ser posible
	 */
	@Test
	void testMetodoSetYGetCantidadNegativa() {
		int cantidadEsperada = -1000;
		Cafetera c = new Cafetera();
		c.setCantidadActual(cantidadEsperada);
		assertEquals(cantidadEsperada, c.getCantidadActual());
	}
	
	/**
	 * Debido a que no se ha hecho manejo de excepciones en el método, se
	 * permite asignar una cantidad superior a la capacidad máxima a la cafetera. Esto NO
	 * debería ser posible
	 */
	@Test
	void testMetodoSetYGetCantidadMayorQueCapacidadMax() {
		int cantidadEsperada = 1500;
		Cafetera c = new Cafetera();
		c.setCantidadActual(cantidadEsperada);
		assertEquals(cantidadEsperada, c.getCantidadActual());
	}
	
	/**
	 * Prueba del método llenarCafetera(). Este deberá igualar la cantidad de la cafetera
	 * a la capacidad máxima de la misma
	 */
	@Test
	void testLlenarCafetera() {
		Cafetera c = new Cafetera();
		assertEquals(0,c.getCantidadActual());
		c.llenarCafetera();
		assertEquals(c.getCapacidadMaxima(), c.getCantidadActual());
	}
	
	/**
	 * Prueba del método vaciarCafetera(). Este deberá asignarle al atributo cantidadActual de
	 * la cafetera el valor 0.
	 */
	@Test
	void testVaciarCafetera() {
		int capacidadMaxima = 2000;
		Cafetera c = new Cafetera(capacidadMaxima, capacidadMaxima);
		assertEquals(c.getCapacidadMaxima(), c.getCantidadActual());
		c.vaciarCafetera();
		assertEquals(0,c.getCantidadActual());
	}
	
	/**
	 * Prueba del método agregarCafe() de la cafetera. Este deberá sumar la cantidad
	 * introducida por parámetro a la cantidadActual de la cafeera.
	 * ANOTACIÖN: AUNQUE NO SE HAYA HECHO UNA PRUEBA CONCRETA PARA ESTE MÉTODO, AL
	 * NO DEJAR DE SER UN SET QUE SUMA, ESTE MÉTODO TIENE EL MISMO FALLO QUE EL SETTER,
	 * ES DECIR, QUE A BASE DE SUMAR CANTIDADES POSITIVAS PUEDE LLEGAR A ASIGNAR UNA CANTIDAD
	 * DE CAFÉ SUPERIOR A LA CAPACIDAD MÁXIMA. ADEMÁS DE QUE AL AGREGAR CANTIDADES NEGATIVAS,
	 * LO CUÁL ESTÁ PERMITIDO POR EL MÉTODO, PODRÍAMOS LLEGAR A TENER UNA CANTIDAD NEGATIVA
	 * DE CAFÉ EN LA CAFETERA. ESTAS SITUACIONES NO DEBERÍAN SER POSIBLES
	 */
	@Test
	void testAgregarCafe() {
		int cantidadEsperada = 800;
		int cantidadInicial = 500;
		int capacidadMaxima = 2000;
		Cafetera c = new Cafetera(capacidadMaxima, cantidadInicial);
		assertEquals(500, c.getCantidadActual());
		assertEquals(2000, c.getCapacidadMaxima());
		c.agregarCafe(300);
		assertEquals(cantidadEsperada, c.getCantidadActual());
	}
	
	/**
	 * Prueba del primer caso contemplado para el método servirTaza() de la cafetera, 
	 * obtenidos mediante pruebas de caja blanca con el método.
	 * En este caso, la cafetera está vacía, por lo que el método deerá devolver 0 e
	 * imprimir por pantalla el siguiente mensaje mensaje: "Lo siento, pero no queda café"
	 */
	@Test
	void testServirTazaCaso1() {
		Cafetera c = new Cafetera();
		int res = c.servirTaza(100);
		assertEquals(0, res);
	}
	
	/**
	 * Prueba del segundo caso contemplado para el método servirTaza() de la cafetera, 
	 * obtenidos mediante pruebas de caja blanca con el método.
	 * En este caso, se pide servir más café del que queda en la cafetera o todo lo que queda. 
	 * El método debería devolver la cantidad restante en la cafetera e imprimir el siguiente
	 * mensaje: "Se ha servido todo lo que quedaba (cantidadActual c.c.)"
	 */
	@Test
	void testServirTazaCaso2() {
		int cantidadActual = 300;
		Cafetera c = new Cafetera(1000, cantidadActual);
		int res = c.servirTaza(400);
		assertEquals(cantidadActual, res);
		assertEquals(0, c.getCantidadActual());
	}
	
	/**
	 * Prueba del tercer y ultimo caso contemplado para el método servirTaza() de la cafetera, 
	 * obtenidos mediante pruebas de caja blanca con el método.
	 * En este caso, se pide servir menos de la cantidad restante de café en la cafetera.
	 * El método deberá devolver la cantidad de café que se pide servir e imprimir el
	 * siguiente mensaje: "Todavía quedan cantidadActual c.c."
	 */
	@Test
	void testServirTazaCaso3() {
		int cantidadActual = 500;
		int cantidadServida = 300;
		int cantidadRestante = cantidadActual - cantidadServida;
		Cafetera c = new Cafetera(1000, cantidadActual);
		int res = c.servirTaza(cantidadServida);
		assertEquals(cantidadServida, res);
		assertEquals(cantidadRestante, c.getCantidadActual());
	}

}
