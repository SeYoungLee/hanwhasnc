package soundsystem;
import org.springframework.beans.factory.annotation.Autowired;

public class CDPlayer implements MediaPlayer {
  private CompactDisc cd;

  public CDPlayer(CompactDisc cd) {
    this.cd = cd;
  }

  public void play() {
	if(1 == 1) {
		throw new RuntimeException("play exception!");
	}
    cd.play();
  }

}
