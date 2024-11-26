package med.voll.api.controller;

import jakarta.transaction.Transactional;
import jakarta.validation.Valid;
import med.voll.api.medico.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.web.PageableDefault;
import org.springframework.web.bind.annotation.*;


@RestController
@RequestMapping("/medicos")
public class MedicoController {
    @Autowired
    private MedicoRespository medicoRespository;
    @PostMapping
    public void registrarMedico(@RequestBody @Valid DatosRegistroMedico datosRegistroMedico){
        System.out.println(datosRegistroMedico);
        medicoRespository.save(new Medico(datosRegistroMedico));

    }

    @GetMapping
    public Page<DatosListadoMedico> listadoMedicos(@PageableDefault(size = 2) Pageable paginacion){
        return medicoRespository.findByActivoTrue(paginacion).map(DatosListadoMedico::new);
        /*return medicoRespository.findAll(paginacion).map(DatosListadoMedico::new);*/
    }
    @PutMapping
    @Transactional
    public void actualizarMedico(@RequestBody @Valid DatosActualizarMedico datosActualizarMedico){
        Medico medico = medicoRespository.getReferenceById(datosActualizarMedico.id());
        medico.actualizarDatos(datosActualizarMedico);
    }

    //DELETE LOGICO
    @DeleteMapping("/{id}")
    @Transactional
    public void eliminarMedico(@PathVariable Long id){
        Medico medico = medicoRespository.getReferenceById(id);
        medico.desactivarMedico();
    }

    //DELETE EN BASE DE DATOS
    /*public void elminarMedico(@PathVariable Long id){
        Medico medico = medicoRespository.getReferenceById(id);
        medicoRespository.delete(medico);
    }*/
}
