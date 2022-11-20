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
		Figurita f1 = new Figurita(12,TipoGrupo.B,"Argentina","Messi",20000.0,Estado.sinPegar);
	    ad.agregarFigurita(f);
	    ad.agregarFigurita(f1);
		UsuarioFinal uf = new UsuarioFinal(2);
		
		uf.buscarsiElAdministradorCreoLaFiguritaYAgregarFigu(ad.getFiguritaParaComercializar(), f);
		uf.buscarsiElAdministradorCreoLaFiguritaYAgregarFigu(ad.getFiguritaParaComercializar(), f1);
		
	    assertEquals(2, uf.getFiguritiasEnElStock().size());
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
		Administrador ad = new Administrador(1);
		Figurita f = new Figurita(11,TipoGrupo.A,"Qatar","Alfha",20000.0,Estado.pegada);
	    ad.agregarFigurita(f);
		UsuarioFinal uf = new UsuarioFinal(2);
		
		uf.buscarsiElAdministradorCreoLaFiguritaYAgregarFigu(ad.getFiguritaParaComercializar(), f);
		uf.buscarsiElAdministradorCreoLaFiguritaYAgregarFigu(ad.getFiguritaParaComercializar(), f);
        assertEquals(2, uf.getFiguritiasEnElStock().size());
	}
	
	@Test 
	public void queUnUsuarioFinalPuedaPegarUnaFigurita() throws YaFuePegada, NoSeEncontroLaFigurita, NoSePudoAgregarException {
		Administrador ad = new Administrador(1);
		Figurita f = new Figurita(11,TipoGrupo.A,"Qatar","Alfha",20000.0,Estado.sinPegar);
		
	    ad.agregarFigurita(f);
	    
	    
		UsuarioFinal uf = new UsuarioFinal(2);
		uf.buscarsiElAdministradorCreoLaFiguritaYAgregarFigu(ad.getFiguritaParaComercializar(), f);
		uf.pegarFigu(f);
		assertEquals(1,uf.getAlbumDeFiguritas().size());
	}
	
	
	@Test(expected = YaFuePegada.class)
	public void queUnUsuarioFinalNoPuedaPegarUnaFiguritaRepetida() throws YaFuePegada, NoSeEncontroLaFigurita, NoSePudoAgregarException {
		Administrador ad = new Administrador(1);
		Figurita f = new Figurita(11,TipoGrupo.A,"Qatar","Alfha",20000.0,Estado.sinPegar);
		
	    ad.agregarFigurita(f);
	    
	    
		UsuarioFinal uf = new UsuarioFinal(2);
		uf.buscarsiElAdministradorCreoLaFiguritaYAgregarFigu(ad.getFiguritaParaComercializar(), f);
		uf.buscarsiElAdministradorCreoLaFiguritaYAgregarFigu(ad.getFiguritaParaComercializar(), f);
		uf.pegarFigu(f);
		uf.pegarFigu(f);
		assertEquals(1,uf.getAlbumDeFiguritas().size());
	}
	
	@Test 
	public void queLasFiguritasAgregadasDeFormaDesordenadaQuedenOrdenadas() throws NoSePudoAgregarException  {
		Administrador ad = new Administrador(1);
		Figurita f = new Figurita(11,TipoGrupo.A,"Inglaterra", "Harry Kane",20000.0,Estado.sinPegar);
		Figurita f1 = new Figurita(12,TipoGrupo.H, "Paises Bajos", "Virgil van Dijk",20000.0,Estado.sinPegar);
		Figurita f2 = new Figurita(13,TipoGrupo.C,"Ecuador", "Caicedo",20000.0,Estado.sinPegar);
		Figurita f3 = new Figurita(14,TipoGrupo.C,"Ecuador", "Reasco",20000.0,Estado.sinPegar);
		
	    ad.agregarFigurita(f2);
	    ad.agregarFigurita(f);
	    ad.agregarFigurita(f3);
	    ad.agregarFigurita(f1);
	    System.out.println(ad.getFiguritaParaComercializar().toString());
	}
	
	@Test
	public void queSePuedaRealizarElIntercambioDeFiguritasEntreDosUsuariosFinales() throws NoSePudoAgregarException, NoSeEncontroLaFigurita, YaFuePegada {
		Administrador ad = new Administrador(1);
		Figurita f = new Figurita(11,TipoGrupo.A,"Qatar","Alfha",20000.0,Estado.sinPegar);
		Figurita f1 = new Figurita(12,TipoGrupo.H, "Paises Bajos", "Virgil van Dijk",20000.0,Estado.sinPegar);
		Figurita f2 = new Figurita(13,TipoGrupo.C,"Ecuador", "Caicedo",20000.0,Estado.sinPegar);
		Figurita f3 = new Figurita(14,TipoGrupo.C,"Ecuador", "Reasco",20000.0,Estado.sinPegar);
		Figurita f4 = new Figurita(15,TipoGrupo.D,"Argentina", "Messi",20000.0,Estado.sinPegar);
		 ad.agregarFigurita(f);
		 ad.agregarFigurita(f1);
		 ad.agregarFigurita(f2);
		 ad.agregarFigurita(f3);
		 ad.agregarFigurita(f4);
		// System.out.println(ad.getFiguritaParaComercializar().toString());
		UsuarioFinal uf = new UsuarioFinal(2);
		uf.buscarsiElAdministradorCreoLaFiguritaYAgregarFigu(ad.getFiguritaParaComercializar(), f);
		uf.buscarsiElAdministradorCreoLaFiguritaYAgregarFigu(ad.getFiguritaParaComercializar(), f1);
		uf.buscarsiElAdministradorCreoLaFiguritaYAgregarFigu(ad.getFiguritaParaComercializar(), f2);
		uf.buscarsiElAdministradorCreoLaFiguritaYAgregarFigu(ad.getFiguritaParaComercializar(), f3);
		System.out.println("Usuario 1: "+uf.getFiguritiasEnElStock().toString());
		
		UsuarioFinal uf2 = new UsuarioFinal(3);
		uf2.buscarsiElAdministradorCreoLaFiguritaYAgregarFigu(ad.getFiguritaParaComercializar(), f4);
		System.out.println("Usuario 2: "+uf2.getFiguritiasEnElStock().toString());
		uf.cambiarFiguritaConOtroUsuarioFinal(uf, uf2, f,f4);
		System.out.println("Usuario 1: "+uf.getFiguritiasEnElStock().toString());
		System.out.println("Usuario 2: "+uf2.getFiguritiasEnElStock().toString());
		
	}
	
	@Test (expected = NoSeEncontroLaFigurita.class)
	public void queNoSePuedaIntercambiarUnaFiguritaDeUnUsuarioQueNoLaTenga()  throws NoSePudoAgregarException, NoSeEncontroLaFigurita, YaFuePegada {
		Administrador ad = new Administrador(1);
		Figurita f = new Figurita(11,TipoGrupo.A,"Qatar","Alfha",20000.0,Estado.sinPegar);
		Figurita f1 = new Figurita(12,TipoGrupo.H, "Paises Bajos", "Virgil van Dijk",20000.0,Estado.sinPegar);
		Figurita f2 = new Figurita(13,TipoGrupo.C,"Ecuador", "Caicedo",20000.0,Estado.sinPegar);
		Figurita f3 = new Figurita(14,TipoGrupo.C,"Ecuador", "Reasco",20000.0,Estado.sinPegar);
		Figurita f4 = new Figurita(15,TipoGrupo.D,"Argentina", "Messi",20000.0,Estado.sinPegar);
		 ad.agregarFigurita(f);
		 ad.agregarFigurita(f1);
		 ad.agregarFigurita(f2);
		 ad.agregarFigurita(f3);
		 ad.agregarFigurita(f4);
		// System.out.println(ad.getFiguritaParaComercializar().toString());
		UsuarioFinal uf = new UsuarioFinal(2);
		
		uf.buscarsiElAdministradorCreoLaFiguritaYAgregarFigu(ad.getFiguritaParaComercializar(), f1);
		uf.buscarsiElAdministradorCreoLaFiguritaYAgregarFigu(ad.getFiguritaParaComercializar(), f2);
		uf.buscarsiElAdministradorCreoLaFiguritaYAgregarFigu(ad.getFiguritaParaComercializar(), f3);
		//System.out.println("Usuario 1: "+uf.getFiguritiasEnElStock().toString());
		
		UsuarioFinal uf2 = new UsuarioFinal(3);
		uf2.buscarsiElAdministradorCreoLaFiguritaYAgregarFigu(ad.getFiguritaParaComercializar(), f4);
		//System.out.println("Usuario 2: "+uf2.getFiguritiasEnElStock().toString());
		uf.cambiarFiguritaConOtroUsuarioFinal(uf, uf2, f,f4);
		//System.out.println("Usuario 1: "+uf.getFiguritiasEnElStock().toString());
		//System.out.println("Usuario 2: "+uf2.getFiguritiasEnElStock().toString());
	}
	
	@Test (expected = YaFuePegada.class)
	public void queNoSePuedaIntercambiarUnaFiguritaDeUnUsuarioQueYaLaHayaPegado()  throws NoSePudoAgregarException, NoSeEncontroLaFigurita, YaFuePegada {
		Administrador ad = new Administrador(1);
		Figurita f = new Figurita(11,TipoGrupo.A,"Qatar","Alfha",20000.0,Estado.pegada);
		Figurita f1 = new Figurita(12,TipoGrupo.H, "Paises Bajos", "Virgil van Dijk",20000.0,Estado.sinPegar);
		Figurita f2 = new Figurita(13,TipoGrupo.C,"Ecuador", "Caicedo",20000.0,Estado.sinPegar);
		Figurita f3 = new Figurita(14,TipoGrupo.C,"Ecuador", "Reasco",20000.0,Estado.sinPegar);
		Figurita f4 = new Figurita(15,TipoGrupo.D,"Argentina", "Messi",20000.0,Estado.sinPegar);
		 ad.agregarFigurita(f);
		 ad.agregarFigurita(f1);
		 ad.agregarFigurita(f2);
		 ad.agregarFigurita(f3);
		 ad.agregarFigurita(f4);
		// System.out.println(ad.getFiguritaParaComercializar().toString());
		UsuarioFinal uf = new UsuarioFinal(2);
		uf.buscarsiElAdministradorCreoLaFiguritaYAgregarFigu(ad.getFiguritaParaComercializar(), f);
		uf.buscarsiElAdministradorCreoLaFiguritaYAgregarFigu(ad.getFiguritaParaComercializar(), f1);
		uf.buscarsiElAdministradorCreoLaFiguritaYAgregarFigu(ad.getFiguritaParaComercializar(), f2);
		uf.buscarsiElAdministradorCreoLaFiguritaYAgregarFigu(ad.getFiguritaParaComercializar(), f3);
		//System.out.println("Usuario 1: "+uf.getFiguritiasEnElStock().toString());
		
		UsuarioFinal uf2 = new UsuarioFinal(3);
		uf2.buscarsiElAdministradorCreoLaFiguritaYAgregarFigu(ad.getFiguritaParaComercializar(), f4);
		//System.out.println("Usuario 2: "+uf2.getFiguritiasEnElStock().toString());
		uf.cambiarFiguritaConOtroUsuarioFinal(uf, uf2, f,f4);
		//System.out.println("Usuario 1: "+uf.getFiguritiasEnElStock().toString());
		//System.out.println("Usuario 2: "+uf2.getFiguritiasEnElStock().toString());
	}

}
