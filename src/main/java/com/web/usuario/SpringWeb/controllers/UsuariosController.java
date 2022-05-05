package com.web.usuario.SpringWeb.controllers;

import java.util.List;
import com.web.usuario.SpringWeb.models.UsuarioUrbana;
import com.web.usuario.SpringWeb.repositorio.UsuariosRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import java.util.Optional;



@Controller
public class UsuariosController {


    @Autowired
    private UsuariosRepo repo;

  @GetMapping("/usuarios")
  public String index(Model model){
    List<UsuarioUrbana> usuarios = (List<UsuarioUrbana>)repo.findAll();
    model.addAttribute("usuarios", usuarios);
    return "usuarios/index";
  }


  @GetMapping("/usuarios/novo")
  public String novo(){
    return "usuarios/novo";
  }

  @PostMapping("/usuarios/criar")
  public String criar(UsuarioUrbana usuario){
    repo.save(usuario);
    return "redirect:/usuarios";
  }
 
  @GetMapping("/usuarios/{id}")
  public String busca(@PathVariable int id, Model model){
    Optional<UsuarioUrbana> admin = repo.findById(id);
    try{
      model.addAttribute("usuario", admin.get());
    }
    catch(Exception err){ return "redirect:/usuarios"; }

    return "/usuarios/editar";
  }

  @PostMapping("/usuarios/{id}/atualizar")
  public String atualizar(@PathVariable int id, UsuarioUrbana usuario){
    // if(!repo.exist(id)){
    if(!repo.existsById(id)){
      return "redirect:/usuarios";
    }

    repo.save(usuario);

    return "redirect:/usuarios";
  }

  @GetMapping("/usuarios/{id}/excluir")
  public String excluir(@PathVariable int id){
    repo.deleteById(id);
    return "redirect:/usuarios";
  }
}