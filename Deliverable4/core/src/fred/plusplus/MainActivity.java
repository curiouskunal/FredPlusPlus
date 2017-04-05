package fred.plusplus;

import com.badlogic.gdx.ApplicationAdapter;
import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.graphics.GL20;
public class MainActivity extends ApplicationAdapter {

	private activity_main view;
	private FredAttributeDataStore fred;
	static boolean titleScreen;

	@Override
	//create() gets called once, at the start of the game launch
	public void create () {
        fred = new FredAttributeDataStore();
        view = new activity_main(fred);
		titleScreen = true;
	}

	@Override
	//render() gets called every frame
	public void render () {
		//Clear screen
		Gdx.gl.glClearColor(1, 0, 1, 1);
		Gdx.gl.glClear(GL20.GL_COLOR_BUFFER_BIT);

		if (titleScreen){
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

			fred.deteriorate();
		}
	}
	
	@Override
	public void dispose () {
		view.dispose();
		fred.dispose();
	}
}
