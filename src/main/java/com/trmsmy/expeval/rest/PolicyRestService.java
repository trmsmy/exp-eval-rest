package com.trmsmy.expeval.rest;

import static com.trmsmy.expeval.model.ModelMapper.entityToModel;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.trmsmy.expeval.biz.MatchPolicyServiceImpl;
import com.trmsmy.expeval.biz.PolicyMaintanenceService;
import com.trmsmy.expeval.model.MatchPolicyRequest;
import com.trmsmy.expeval.model.MatchPolicyResponse;
import com.trmsmy.expeval.model.Policy;
import com.trmsmy.expeval.persistence.PolicyRepository;
import com.trmsmy.expeval.persistence.entity.PolicyEntity;

@RestController
public class PolicyRestService {

    @Autowired
	private PolicyRepository policyRepo;
    
    @Autowired 
    private PolicyMaintanenceService maintanenceSvc;
    
    @Autowired
    private MatchPolicyServiceImpl matchService;

    @RequestMapping(value = "/ping", method = RequestMethod.GET)
	public ResponseEntity<String> ping() {
		return new ResponseEntity<String>("Ping Successful.", HttpStatus.OK);
	}

	@RequestMapping(value = "/policy/{id}", method = RequestMethod.GET)
    public ResponseEntity<Policy> getPolicy(@PathVariable("id") Integer id) {
        PolicyEntity policyEntity = policyRepo.findById(id);
        return new ResponseEntity<Policy>(entityToModel(policyEntity) , HttpStatus.OK);
    }

	
	@RequestMapping(value = "/policy/match", method = RequestMethod.GET)
    public ResponseEntity<MatchPolicyResponse> matchPolicy(@ModelAttribute  MatchPolicyRequest req) {
        MatchPolicyResponse p = matchService.matchPolicy(req);
        return new ResponseEntity<MatchPolicyResponse>(p, HttpStatus.OK);
    }

	@RequestMapping(value = "/policy/add", method = RequestMethod.POST)
    public ResponseEntity<Policy> addPolicy(@RequestBody  Policy p) {
        Policy policyEntity = maintanenceSvc.addPolicy(p);
        return new ResponseEntity<Policy>(policyEntity , HttpStatus.OK);
    }

}
