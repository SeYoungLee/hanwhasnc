package examples.guestbook.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import examples.guestbook.dao.GuestbookDao;
import examples.guestbook.dto.Guestbook;

@Service
public class GuestbookServiceImpl implements GuestbookService{
	@Autowired
	private GuestbookDao guestbookDao;

	@Override
	@Transactional(readOnly=true)
	public List<Guestbook> getGuestbooks() {
		return guestbookDao.selectAll();
	}

	@Override
	@Transactional
	public Guestbook addGuestbook(Guestbook guestbook) {
		return guestbookDao.insert(guestbook);
	}

	
}
