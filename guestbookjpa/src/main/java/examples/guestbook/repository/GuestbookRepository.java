package examples.guestbook.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import examples.guestbook.domain.Guestbook;

public interface GuestbookRepository extends JpaRepository<Guestbook, Long> {

}
