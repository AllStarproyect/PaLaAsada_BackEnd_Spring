package org.palaasada.backend.service;

import org.palaasada.backend.model.Tag;
import org.palaasada.backend.repository.TagRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class TagService {

    @Autowired
    private TagRepository tagRepository;

    public List<Tag> findAll() {
        return tagRepository.findAll();
    }

    public Optional<Tag> findById(Integer id) {
        return tagRepository.findById(id);
    }

    public Tag save(Tag tag) {
        return tagRepository.save(tag);
    }

    public Tag update(Integer id, Tag tag) {
        tag.setTagId(id);
        return tagRepository.save(tag);
    }

    public void delete(Integer id) {
        tagRepository.deleteById(id);
    }
}