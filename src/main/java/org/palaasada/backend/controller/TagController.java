package org.palaasada.backend.controller;

import org.palaasada.backend.model.Tag;
import org.palaasada.backend.service.TagService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/tags")
public class TagController {

    @Autowired
    private TagService tagService;

    @GetMapping
    public ResponseEntity<List<Tag>> findAll() {
        return ResponseEntity.ok(tagService.findAll());
    }

    @GetMapping("/{id}")
    public ResponseEntity<Tag> findById(@PathVariable Integer id) {
        return tagService.findById(id)
                .map(ResponseEntity::ok)
                .orElse(ResponseEntity.notFound().build());
    }

    @PostMapping
    public ResponseEntity<Tag> save(@RequestBody Tag tag) {
        return ResponseEntity.ok(tagService.save(tag));
    }

    @PutMapping("/{id}")
    public ResponseEntity<Tag> update(
            @PathVariable Integer id,
            @RequestBody Tag tag) {

        return ResponseEntity.ok(tagService.update(id, tag));
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> delete(@PathVariable Integer id) {

        tagService.delete(id);

        return ResponseEntity.noContent().build();
    }
}