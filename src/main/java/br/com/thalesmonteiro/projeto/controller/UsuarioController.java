package br.com.thalesmonteiro.projeto.controller;

import br.com.thalesmonteiro.projeto.dto.UsuarioDTO;
import br.com.thalesmonteiro.projeto.service.UsuarioService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
@RestController
@RequestMapping(value = "/users")
public class UsuarioController {

    @Autowired
    private UsuarioService usuarioService;

    @GetMapping
    public List<UsuarioDTO> listarTodos() {
        return usuarioService.listarTodos();
    }
    @PostMapping
    public  UsuarioDTO salvar(@RequestBody UsuarioDTO usuario) {
        usuarioService.inserir(usuario);
        return usuario;
    }
    @PutMapping
    public  UsuarioDTO alterar(@RequestBody UsuarioDTO usuario) {
        return  usuarioService.alterar(usuario);

    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> excluir(@PathVariable(value = "id")Long id){
            usuarioService.excluir(id);
            return ResponseEntity.ok().build();
    }



}
