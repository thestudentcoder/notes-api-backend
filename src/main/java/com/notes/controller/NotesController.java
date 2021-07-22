package com.notes.controller;

import com.notes.entity.Note;
import com.notes.repository.NotesRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/v1")
@CrossOrigin("*")
public class NotesController {

    @Autowired
    NotesRepository notesRepository;

    @GetMapping("/notes")
    public ResponseEntity<List<Note>> readNotes() {
        return new ResponseEntity<>(notesRepository.findAll(), HttpStatus.OK);
    }

    @PostMapping("/notes")
    public ResponseEntity<Note> createNote(@RequestBody Note note) {
        return new ResponseEntity<>(notesRepository.save(note), HttpStatus.CREATED);
    }

    @GetMapping("/notes/{id}")
    public ResponseEntity<Note> readNote(@PathVariable Long id) {
        return new ResponseEntity<>(notesRepository.findById(id).orElse(null), HttpStatus.OK);
    }

    @DeleteMapping("/notes/{id}")
    public ResponseEntity<Note> deleteNote(@PathVariable Long id) {
        notesRepository.deleteById(id);
        return new ResponseEntity<>(HttpStatus.NO_CONTENT);
    }

    @PutMapping("/notes")
    public ResponseEntity<Note> updateNote(@RequestBody Note note) {
        return new ResponseEntity<>(notesRepository.save(note), HttpStatus.OK);
    }
}
