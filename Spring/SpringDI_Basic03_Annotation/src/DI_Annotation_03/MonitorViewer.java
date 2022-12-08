package DI_Annotation_03;

import javax.annotation.Resource;

public class MonitorViewer {

	private Recorder recorder;

	public Recorder getRecorder() {
		return this.recorder;
	}

	// @Autowired (by type 예외)
	@Resource(name="yy") // 같은 타입이 있을 때 name값으로 찾음 >> Resource
	public void setRecorder(Recorder recorder) {
		this.recorder = recorder;
		System.out.println("setRecorder: " + this.recorder);
	}

}
