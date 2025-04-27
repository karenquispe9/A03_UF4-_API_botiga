package com.accesadades.botiga.Service;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.accesadades.botiga.DTO.SubCategoriaDTO;
import com.accesadades.botiga.DomainModel.SubCategoria;
import com.accesadades.botiga.Mapper.SubCategoriaMapper;
import com.accesadades.botiga.Repository.SubCategoriaRepository;

@Service
public class SubCategoriaServiceImpl implements BotigaService<SubCategoriaDTO, Long> {

    @Autowired
    private SubCategoriaRepository subCategoriaRepository;

    @Autowired
    private SubCategoriaMapper subCategoriaMapper;

    @Override
    public List<SubCategoriaDTO> findAll() {
        return subCategoriaRepository.findAll()
                .stream()
                .map(subCategoriaMapper::subCategoriaToSubCategoriaDTO)
                .collect(Collectors.toList());
    }

    @Override
    public Optional<SubCategoriaDTO> findById(Long id) {
        return subCategoriaRepository.findById(id)
                .map(subCategoriaMapper::subCategoriaToSubCategoriaDTO);
    }

    @Override
    public void save(SubCategoriaDTO subCategoriaDTO) {
        SubCategoria subCategoria = subCategoriaMapper.subCategoriaDTOToSubCategoria(subCategoriaDTO);
        subCategoriaRepository.save(subCategoria);
    }

    @Override
    public void deleteById(Long id) {
        subCategoriaRepository.deleteById(id);
    }
}
