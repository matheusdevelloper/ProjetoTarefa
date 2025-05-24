package com.example.tarefa.service;

import java.util.ArrayList;
import java.util.List;

import org.springframework.stereotype.Service;

import com.example.tarefa.model.Tarefa;

@Service
public class TarefaService {

    private final List<Tarefa> tarefas = new ArrayList<>();

    public Tarefa adicionarTarefa(Tarefa tarefa){
        tarefas.add(tarefa);
        return tarefa;
    }

    public void deletarTarefa(Long id){
        tarefas.removeIf(identifique -> identifique.getId().equals(id)); 
    }

    public List<Tarefa> listarTarefas(){
        return tarefas;
    }
}
