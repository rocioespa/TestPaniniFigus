package ar.edu.unlam.pb2;

import static org.junit.Assert.*;

import java.util.Set;

import org.junit.Test;

public class TestFiguritas {

	@Test
	public void queSePuedaCrearUnaFigurita () {
	
		Figurita f = new Figurita(11,TipoGrupo.A,"Qatar","Alfa",20000.0, Estado.pegada);
	   // castear
	    assertEquals((Integer)11, f.getCod_figu());
	    assertEquals(TipoGrupo.A, f.getGrupo());
	    assertEquals("Qatar", f.getSeleccion());
	}
	
	@Test
	public void queSePuedaCrearUnAdministrador () throws Exception {
		Sistema s =new Sistema();
		Administrador ad = new Administrador(1);
		s.agregarUsuario(ad);
		assertEquals(1, s.getUsuarios().size());
	}
	
	@Test
	public void queSePuedaCrearUnUsuarioFinal() throws Exception {
		Sistema s =new Sistema();
		UsuarioFinal uf = new UsuarioFinal(2);
		s.agregarUsuario(uf);
		assertEquals(1, s.getUsuarios().size());
	}

	@Test
	public void queUnAdministradorPuedaAgregarUnaFigurita() throws NoSePudoAgregarException {
		Administrador ad = new Administrador(1);
		Figurita f = new Figurita(11,TipoGrupo.A,"Qatar","Alfha",20000.0,Estado.pegada);
	    ad.agregarFigurita(f);
	    assertEquals(1, ad.getFiguritaParaComercializar().size());
	}
	
	@Test
	public void queUnUsuarioFinalPuedaAgregarUnaFigurita() throws NoSePudoAgregarException{
		Administrador ad = new Administrador(1);
		Figurita f = new Figurita(11,TipoGrupo.A,"Qatar","Alfha",20000.0,Estado.pegada);
	    ad.agregarFigurita(f);
		UsuarioFinal uf = new UsuarioFinal(2);
		Set<Figurita> figuritas = ad.getFiguritaParaComercializar();
		uf.figuritsValida(figuritas,f);
	    assertEquals(1, uf.getFiguritiasEnElStock().size());
	    System.out.println(uf.getFiguritiasEnElStock().toString());
	}
	
	@Test (expected = NoSePudoAgregarException.class)
	public void queUnAdministradorNoPuedaAgregarUnaFiguritaExistente() throws NoSePudoAgregarException {
		Administrador ad = new Administrador(1);
		Figurita f = new Figurita(11,TipoGrupo.A,"Qatar","Alfha",20000.0,Estado.pegada);
		Figurita f1 = new Figurita(11,TipoGrupo.A,"Qatar","Alfha",20000.0,Estado.pegada);
	    ad.agregarFigurita(f);
	    ad.agregarFigurita(f1);
	    
	}
	
	@Test
	public void queUnUsuarioFinalSiPuedaAgregarFiguritasExistentes() throws NoSePudoAgregarException {
		UsuarioFinal uf = new UsuarioFinal(2);
		Figurita f = new Figurita(11,TipoGrupo.A,"Qatar","Alfha",20000.0,Estado.pegada);
	    uf.agregarFigurita(f);
	    uf.agregarFigurita(f);
        assertEquals(2, uf.getFiguritiasEnElStock().size());
	}
	
	@Test
	public void queUnUsuarioFinalPuedaPegarUnaFigurita() throws YaFuePegada, NoSeEncontroLaFiguritaEnElStock {
		
		UsuarioFinal uf = new UsuarioFinal(2);
		
		Figurita f = new Figurita(11,TipoGrupo.A,"Qatar","Alfha",20000.0,Estado.sinPegar);
		uf.agregarFigurita(f);
		uf.pegarFigu(f);
	}
	
	
	@Test(expected = YaFuePegada.class)
	public void queUnUsuarioFinalNoPuedaPegarUnaFiguritaRepetida() throws YaFuePegada {
		UsuarioFinal uf = new UsuarioFinal(2);
		Figurita f = new Figurita(11,TipoGrupo.A,"Qatar","Alfha",20000.0,Estado.pegada);
		Figurita f1 = new Figurita(11,TipoGrupo.A,"Qatar","Alfha",20000.0,Estado.pegada);
		uf.pegarFigu(1, f);
		uf.pegarFigu(1, f1);
	}
	
//	@Test 
//	public void queLasFiguritasAgregadasDeFormaDesordenadaQuedenOrdenadas() throws NoSePudoAgregarException {
//		Administrador ad = new Administrador(1);
//		Figurita f = new Figurita(11,TipoGrupo.A,"Qatar","Alfha",20000.0);
//		Figurita f1 = new Figurita(12,TipoGrupo.H,"Ecuador","Alfha",20000.0);
//		Figurita f2 = new Figurita(13,TipoGrupo.C,"Senegal","Alfha",20000.0);
//		Figurita f3 = new Figurita(14,TipoGrupo.D,"Paises Bajos","Alfha",20000.0);
//		
//	    ad.agregarFigurita(f2);
//	    ad.agregarFigurita(f);
//	    ad.agregarFigurita(f3);
//	    ad.agregarFigurita(f1);
//	    System.out.println(ad.getFigus().toString());
//	}
	
//	@Test 
//	public void queSePuedaRealizarElIntercambioDeFiguritasEntreDosUsuariosFinales() throws YaFuePegada {
//		UsuarioFinal uf = new UsuarioFinal(2);
//		UsuarioFinal uf1 = new UsuarioFinal(1);
//		Figurita f = new Figurita(11,TipoGrupo.A,"Qatar","Alfha",20000.0);
//		Figurita f1 = new Figurita(12,TipoGrupo.B,"Ecuador","Alfha",20000.0);
//		uf.agregarFigurita(f1);
//		uf1.agregarFigurita(f);
//		uf.cambioDeFigus(uf, uf1);
//		System.out.println(uf.getStock().toString());
//		System.out.println(uf1.getStock().toString());
//	}
	
	

}
