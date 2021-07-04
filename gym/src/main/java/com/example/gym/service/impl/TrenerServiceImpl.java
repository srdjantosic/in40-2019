package com.example.gym.service.impl;
import com.example.gym.entity.Trener;
import com.example.gym.entity.dto.TrenerDTO;
import com.example.gym.repository.TrenerRepository;
import com.example.gym.service.TrenerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.util.List;




@Service
public class TrenerServiceImpl implements TrenerService {

	private final TrenerRepository trenerrepository;

	@Autowired
	public TrenerServiceImpl(TrenerRepository trenerrepository) {
		super();
		this.trenerrepository = trenerrepository;
	}

	@Override
	public Trener findOne(String korisnicko_ime) {
		Trener trener = this.trenerrepository.getOne(korisnicko_ime);
        return trener;
		
	}

	@Override
	public List<Trener> findAll() {
		List<Trener> trener = this.trenerrepository.findAll();
        return trener;
	}

	@Override
	public Trener create(Trener trener) throws Exception {
       Trener newTrener = this.trenerrepository.save(trener);
        return newTrener;
	}

	@Override
	public Trener update(String korisnicko) throws Exception {
		Trener trenerToUpdate = this.trenerrepository.getOne(korisnicko);
		
        if (trenerToUpdate == null) {
            throw new Exception("Trener doesn't exist!");
        }

      
       
        trenerToUpdate.setAktivan(true);
        

     
        Trener savedEm = this.trenerrepository.save(trenerToUpdate);
        return savedEm;
	}

	@Override
	public void delete(String korisnicko_ime) {
		Trener trenerToUpdate = this.trenerrepository.getOne(korisnicko_ime);
		trenerToUpdate.setObrisan(true);
		this.trenerrepository.save(trenerToUpdate);
		
	}

	@Override
	public List<Trener> findTrenerNeAktivan() {
		List<Trener> trener =this.trenerrepository.findFalse();
		return trener;
	}

	
	
	
	

}
