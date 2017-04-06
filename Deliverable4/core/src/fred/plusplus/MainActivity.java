package fred.plusplus;

import com.badlogic.gdx.ApplicationAdapter;
import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.graphics.GL20;
import java.util.ArrayList;
import java.util.Arrays;
public class MainActivity extends ApplicationAdapter {

	private activity_main view;
	private RandomEventGenerator eventGen;
	private FredAttributeDataStore fred;
	static boolean titleScreen;
	private FredPoller poller;
	private DeteriorateController deteriorateController;

	@Override
	//create() gets called once, at the start of the game launch
	public void create () {
        fred = new FredAttributeDataStore();
		ArrayList<RandomEvent> list = new ArrayList<RandomEvent>(Arrays.asList(
				new RandomEvent("car_crash",5),
				new RandomEvent("fall_down_stairs",8),
				new RandomEvent("panic_attack",10),
				new RandomEvent("burst_of_motivation",10),
				new RandomEvent("ebola",1),
				new RandomEvent("acid_reflex",10),
				new RandomEvent("puberty",8),
				new RandomEvent("twisted_ankle",10),
				new RandomEvent("slowed_motabolism",10),
				new RandomEvent("slept_on_neck",15)));
		eventGen = new RandomEventGenerator(100,list);
        view = new activity_main(fred);

		poller = new FredPoller(fred);
		deteriorateController = new DeteriorateController(fred);

		titleScreen = true;

		Thread pollerThread = new Thread(poller);
		pollerThread.start();

		Thread deteriorateThread = new Thread(deteriorateController);
		deteriorateThread.start();
	}

	@Override
	//render() gets called every frame
	public void render () {
		//Clear screen
		Gdx.gl.glClearColor(1, 0, 1, 1);
		Gdx.gl.glClear(GL20.GL_COLOR_BUFFER_BIT);

		if (fred.dead()) {
			view.drawBG();
			view.drawDeathPage(fred.getBaseTexture());
		}
		else if (titleScreen) {
			view.drawBG();
			view.drawTitlePage(fred.getBaseTexture(), fred.getExteriorTexture());
		}
		else {
			view.drawBG();
			view.draw(fred.getBaseTexture(), 0, 0);
			view.drawSubSystems(fred.getVisibleSystems());
			view.drawButtons();

			for (Metric m : fred.getMetrics()) {
				view.drawMetric(m);
			}
			eventGen.GenerateEvent();
			fred.deteriorate();
		}
	}
	
	@Override
	public void dispose () {
		view.dispose();
		fred.dispose();
	}
}
