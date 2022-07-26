package com.bookStore.bookStore.resources;

import java.util.ArrayList;
import java.util.List;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.bookStore.bookStore.entities.Book;

@RestController
@RequestMapping(value = "/books")
public class BooksResource {

	@GetMapping
	public ResponseEntity<List<Book>> findAll() {

		List<Book> myBooksList = new ArrayList<>();
		myBooksList.add(new Book(41,
				"O Fenômeno Gaslighting: Saiba como funciona a estratégia de pessoas manipuladoras para distorcer a verdade e manter você sob controle",
				304, "Stephanie Sarkis"));
		myBooksList.add(new Book(56, "Scrum: A arte de fazer o dobro do trabalho na metade do tempo", 256, "Jeff Sutherland"));
		myBooksList.add(new Book(76, "Rápido e devagar: Duas formas de pensar", 608, "Daniel Kahneman"));
		myBooksList.add(new Book(80, "Não Acredite em Tudo Que Você Sente: Identifique seus Esquemas Emocionais e Liberte-se da Ansiedade e da Depressão", 212, "Robert L. Leahy"));
		myBooksList.add(new Book(99, "Os Números Não Mentem: 71 Histórias Para Entender o Mundo ", 400, "Vaclav Smil"));

		return ResponseEntity.ok().body(myBooksList);
	}

}
