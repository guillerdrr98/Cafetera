package cafetera.tests;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;

import cafetera.recursos.Cafetera;

class CafeteraTests {

	@Test
	void testConstructor1() {
		Cafetera c = new Cafetera();
		assertEquals(1000, c.getCapacidadMaxima());
		assertEquals(0, c.getCantidadActual());
	}
	
	@Test
	void testConstructor2() {
		int capacidad = 3000;
		Cafetera c = new Cafetera(capacidad);
		assertEquals(capacidad, c.getCapacidadMaxima());
		assertEquals(c.getCapacidadMaxima(), c.getCantidadActual());
	}
	
	@Test
	void testConstructor3() {
		int capacidad = 3000;
		int cantidad = 400;
		Cafetera c = new Cafetera(capacidad, cantidad);
		assertEquals(capacidad, c.getCapacidadMaxima());
		assertEquals(cantidad, c.getCantidadActual());
	}
	
	@Test
	void testMetodoSetYGetCapacidad() {
		int capacidadEsperada = 2500;
		Cafetera c = new Cafetera();
		c.setCapacidadMaxima(capacidadEsperada);
		assertEquals(capacidadEsperada, c.getCapacidadMaxima());
	}
	
	@Test
	void testMetodoSetYGetCantidad() {
		int cantidadEsperada = 400;
		Cafetera c = new Cafetera();
		c.setCantidadActual(cantidadEsperada);
		assertEquals(cantidadEsperada, c.getCantidadActual());
	}
	
	@Test
	void testLlenarCafetera() {
		Cafetera c = new Cafetera();
		assertEquals(0,c.getCantidadActual());
		c.llenarCafetera();
		assertEquals(c.getCapacidadMaxima(), c.getCantidadActual());
	}
	
	@Test
	void testVaciarCafetera() {
		int capacidadMaxima = 2000;
		Cafetera c = new Cafetera(capacidadMaxima, capacidadMaxima);
		assertEquals(c.getCapacidadMaxima(), c.getCantidadActual());
		c.vaciarCafetera();
		assertEquals(0,c.getCantidadActual());
	}
	
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

}
