package com.example.HackEdu.Classes.publisher;

import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class PublisherService {
    private final PublisherRepository publisherRepository;

    public PublisherService(PublisherRepository publisherRepository) {
        this.publisherRepository = publisherRepository;
    }

    public void addPublisher(Publisher publisher) {
        Optional<Publisher> publisherOptional = publisherRepository.findByEmail(publisher.getEmail());
        if (!publisherOptional.isPresent()) {
            publisherRepository.save(publisher);
        }

    }
}
