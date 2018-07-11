package examples.guestbook.service;

import java.util.List;

import examples.guestbook.domain.Guestbook;

public interface GuestbookService {
	public List<Guestbook> getGuestbooks();
	public Guestbook addGuestbook(Guestbook guestbook);
}
