package com.accesadades.botiga.Service;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.accesadades.botiga.DTO.CategoriaDTO;
import com.accesadades.botiga.DomainModel.Categoria;
import com.accesadades.botiga.Mapper.CategoriaMapper;
import com.accesadades.botiga.Repository.CategoriaRepository;

@Service
public class CategoriaServiceImpl implements BotigaService<CategoriaDTO, Long> {

    @Autowired
    private CategoriaRepository categoriaRepository;

    @Autowired
    private CategoriaMapper categoriaMapper;

    @Override
    public List<CategoriaDTO> findAll() {
        return categoriaRepository.findAll()
                .stream()
                .map(categoriaMapper::categoriaToCategoriaDTO)
                .collect(Collectors.toList());
    }

    @Override
    public Optional<CategoriaDTO> findById(Long id) {
        return categoriaRepository.findById(id)
                .map(categoriaMapper::categoriaToCategoriaDTO);
    }

    @Override
    public void save(CategoriaDTO categoriaDTO) {
        Categoria categoria = categoriaMapper.categoriaDTOToCategoria(categoriaDTO);
        categoriaRepository.save(categoria);
    }

    @Override
    public void deleteById(Long id) {
        categoriaRepository.deleteById(id);
    }
}
