package fred.plusplus;

import com.badlogic.gdx.ApplicationAdapter;
import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.InputMultiplexer;
import com.badlogic.gdx.graphics.GL20;

public class MainActivity extends ApplicationAdapter {

	MainView view;
	Fred fred;

	InputMultiplexer multiplexer;

	@Override
	//create() gets called once, at the start of the game launch
	public void create () {
		view = new MainView();
		fred = new Fred();

		//This is how libGDX handles multiple different input listeners
		//Whenever a touch event happens, it will pass it to the first listener
		//If a listener doesn't handle it, it returns false and the event passes to the next listener
		//If a listener does handle the input, it returns true and the multiplexer stops
		multiplexer = new InputMultiplexer();
		multiplexer.addProcessor(new StimuliListener());
		multiplexer.addProcessor(new ToggleSubsystemListener());
		multiplexer.addProcessor(new ShowSubsystemListener());
		Gdx.input.setInputProcessor(multiplexer);
	}

	@Override
	//render() gets called every frame
	public void render () {
		//Clear screen
		Gdx.gl.glClearColor(1, 1, 0, 1);
		Gdx.gl.glClear(GL20.GL_COLOR_BUFFER_BIT);

		view.draw(fred.getBaseTexture(), 0, 0);
		view.drawSubSystems(fred.getVisibleSystems());
	}
	
	@Override
	public void dispose () {
		view.dispose();
		fred.dispose();
	}
}
