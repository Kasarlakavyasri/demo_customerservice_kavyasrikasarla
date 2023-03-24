package edu.iu.p565.customerservice.controller;

import jakarta.validation.Valid;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import edu.iu.p565.customerservice.model.Customer;
import edu.iu.p565.customerservice.repository.CustomerRepository;

@RestController
@RequestMapping("/customers")
public class CustomerController {

    private CustomerRepository repository;

    public CustomerController(CustomerRepository repository) {
        this.repository = repository;
    }

    @GetMapping
    public List<Customer> findAll() {
        return repository.findAll();
    }

    @ResponseStatus(HttpStatus.CREATED)
    @PostMapping

    public int create(@Valid @RequestBody Customer customer) {
        return repository.create(customer);
    }

    @ResponseStatus(HttpStatus.CREATED)
    @PutMapping("/{id}")
    public void update(@Valid @RequestBody Customer customer, @PathVariable int id) {
        repository.update(customer, id);

    }

    @ResponseStatus(HttpStatus.CREATED)
    @DeleteMapping("/{id}")
    public void delete(@PathVariable  int id) {
        repository.delete(id);
    }
}