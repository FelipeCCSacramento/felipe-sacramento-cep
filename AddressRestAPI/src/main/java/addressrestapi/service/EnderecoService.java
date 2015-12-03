package addressrestapi.service;

import java.util.LinkedHashMap;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.fasterxml.jackson.databind.ObjectMapper;

import addressrestapi.dao.EnderecoCompletoDAO;
import addressrestapi.model.EnderecoCompleto;
import addressrestapi.model.ResponseObject;

@Service
public class EnderecoService {

	@Autowired
	private EnderecoCompletoDAO enderecoDAO;
	
	public ResponseObject salvar(EnderecoCompleto end) {
		end.setCep(parseCep(end.getCep()));
		if(!end.getCep().isEmpty()) {
			try {
				enderecoDAO.save(end);
				return new ResponseObject("SUCESSO", "O endereço foi cadastrado com sucesso.");
			} catch (Exception e) {
				return new ResponseObject("ERRO", "O endereço informado já foi cadastrado.");
			}
		}
		
		return new ResponseObject("ERRO", "O CEP informado é inválido");	
	}

	@SuppressWarnings("unchecked")
	public Object buscar(String cep) {
		cep = parseCep(cep);
		if(!cep.isEmpty()) {
			try {
				Map<String, String> map = new LinkedHashMap<String, String>();
				
				EnderecoCompleto end  = enderecoDAO.getByCep(cep);
				end.setCep(end.getCep().substring(0, 5)+"-"+end.getCep().substring(5));
				
				map.put("status", "SUCESSO");
				map.putAll(new ObjectMapper().convertValue(end, Map.class));
				return map;
			} catch (Exception exception) {
				return new ResponseObject("ERRO", "O CEP informado não foi encontrado");
			}
		}
		
		return new ResponseObject("ERRO", "O CEP informado é inválido");
	}
	
	private String parseCep(String cep) {
		if(cep.length() == 9 && !cep.matches("^[0-9]{9}$")) cep = cep.substring(0,5)+cep.substring(6);
		return cep.matches("^[0-9]{8}$") ? cep : "";
	}
}
