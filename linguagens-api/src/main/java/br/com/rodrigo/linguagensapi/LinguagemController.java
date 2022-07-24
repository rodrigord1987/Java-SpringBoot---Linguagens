package br.com.rodrigo.linguagensapi;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.repository.Query;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import jakarta.websocket.server.PathParam;

@RestController
public class LinguagemController {

    @Autowired
    private LinguagemRepository repository;

    @GetMapping("/linguagens")
    public List<Linguagem> ObterLinguagens() {
        List<Linguagem> linguagens = repository.findAll();
        return linguagens;
    }

    @PostMapping("/linguagem")
    public Linguagem CadastrarLinguagem(@RequestBody Linguagem linguagem){
        return repository.save(linguagem);
    }

    @DeleteMapping("/linguagem/{id}")
    public void ExcluirLinguagem(@PathVariable String id){
        repository.deleteById(id);
    }
}
