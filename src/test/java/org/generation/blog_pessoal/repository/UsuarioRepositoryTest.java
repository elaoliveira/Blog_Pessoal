package org.generation.blog_pessoal.repository;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;

import java.util.List;

import org.generation.blog_pessoal.model.Usuario;
import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.TestInstance;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.context.SpringBootTest.WebEnvironment;

@SpringBootTest(webEnvironment = WebEnvironment.RANDOM_PORT)
@TestInstance(TestInstance.Lifecycle.PER_CLASS)
public class UsuarioRepositoryTest {

	@Autowired
	private UsuarioRepository usuarioRepository;
	
	@BeforeAll
	void start() {
	
		Usuario usuario = new Usuario(0L, "Ela Oliv", "ela.o", "13465278");
		
		if(!usuarioRepository.findByUsuario(usuario.getUsuario()).isPresent())
			usuarioRepository.save(usuario);
		
		usuario = new Usuario(0L, "Nik Barb", "nik.b", "12345678");
		
		if(!usuarioRepository.findByUsuario(usuario.getUsuario()).isPresent())
			usuarioRepository.save(usuario);
		
		usuario = new Usuario(0L, "Kamilla Oliv", "kamilla.o", "15624878");
		
		if(!usuarioRepository.findByUsuario(usuario.getUsuario()).isPresent())
			usuarioRepository.save(usuario);
		
		usuario = new Usuario(0L, "Sara Barb", "sara.b", "87654321");
		
		if(!usuarioRepository.findByUsuario(usuario.getUsuario()).isPresent())
			usuarioRepository.save(usuario);
	}
	
	@Test
	@DisplayName("💾 Retorna Nome")
	public void findByRetornaNome() {
	
		Usuario usuario = usuarioRepository.findByNome("Kamilla Oliv");
		assertTrue(usuario.getNome().equals("Kamilla Oliv"));
	}
	
	@Test
	@DisplayName("💾 Retorna 3 Usuarios")
	public void findAllByContainingIgnoreCaseRetornaTresUsuarios() {
		
		List<Usuario> listaDeUsuarios = usuarioRepository.findAllByNomeContainingIgnoreCase("Oliv");
		assertEquals(3, listaDeUsuarios.size());
	}
	
	@AfterAll
	public void end() {
		
		System.out.println("Teste Finalizado");
		
	}
}
