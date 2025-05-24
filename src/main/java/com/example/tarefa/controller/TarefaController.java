package com.example.tarefa.controller;

import java.util.List;

import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.tarefa.model.Tarefa;
import com.example.tarefa.service.TarefaService;

@RestController
@RequestMapping("/api/tarefas")
@CrossOrigin(origins = "*")
public class TarefaController {

    private final TarefaService tarefaService;
    private Long proximoId = 1L;

    public TarefaController(TarefaService tarefaService) {
        this.tarefaService = tarefaService;
    }

    @PostMapping
    public Tarefa adicionarTarefa(@RequestBody Tarefa tarefa){
       tarefa.setId(proximoId++);
       return tarefaService.adicionarTarefa(tarefa);
    }

    @GetMapping
    public List<Tarefa> listarTarefas(){
        return tarefaService.listarTarefas();
    }

    @DeleteMapping("/{id}")
    public void deletarTarefa(@PathVariable Long id){
        tarefaService.deletarTarefa(id);
    }
}
