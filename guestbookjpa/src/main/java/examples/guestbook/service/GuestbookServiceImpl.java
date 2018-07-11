package examples.guestbook.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import examples.guestbook.domain.Guestbook;
import examples.guestbook.repository.GuestbookRepository;

@Service
public class GuestbookServiceImpl implements GuestbookService{
	@Autowired
	private GuestbookRepository guestbookRepository;

	@Override
	@Transactional(readOnly=true)
	public List<Guestbook> getGuestbooks() {
		return guestbookRepository.findAll(new Sort(Sort.Direction.DESC, "id"));
	}

	@Override
	@Transactional
	public Guestbook addGuestbook(Guestbook guestbook) {
		return guestbookRepository.save(guestbook);
	}

	
}
