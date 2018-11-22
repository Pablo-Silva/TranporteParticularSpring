package br.edu.uniopet.tranporteparticular.service;

import br.edu.uniopet.tranporteparticular.model.Cliente;
import br.edu.uniopet.tranporteparticular.repository.ClienteRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class ClienteService implements IClienteService {

    private final
    ClienteRepository clienteRepository;

    @Autowired
    public ClienteService(ClienteRepository clienteRepository) {
        this.clienteRepository = clienteRepository;
    }

    @Override
    public Cliente editCliente(Cliente cliente) {

        if (clienteRepository.existsById(cliente.getIdCliente())){

            clienteRepository.save(cliente);
        }
        return cliente;
    }
}
