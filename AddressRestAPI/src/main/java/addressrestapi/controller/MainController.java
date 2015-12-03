package addressrestapi.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import addressrestapi.model.EnderecoCompleto;
import addressrestapi.model.ResponseObject;
import addressrestapi.service.EnderecoService;


@RestController
public class MainController {
	
	@Autowired
	private EnderecoService enderecoService;
	
	@RequestMapping(value="/busca/{cepEscolhido}", method=RequestMethod.GET)
	public Object busca(@PathVariable("cepEscolhido") String cepEscolhido) {
		return enderecoService.buscar(cepEscolhido);
	}
	
	@RequestMapping(value="/cadastro", method=RequestMethod.POST, consumes=MediaType.APPLICATION_JSON_UTF8_VALUE)
	public ResponseObject cadastro(@RequestBody EnderecoCompleto end) {
		return enderecoService.salvar(end);
	}
	
	@RequestMapping(value={ "/*", "/busca"})
	public ResponseObject othersRequests() {
		return new ResponseObject("ERRO", "O CEP informado é inválido");
	}
	
}
