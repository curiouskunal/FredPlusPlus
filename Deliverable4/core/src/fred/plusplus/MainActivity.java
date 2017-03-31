package fred.plusplus;

import com.badlogic.gdx.ApplicationAdapter;
import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.graphics.GL20;

public class MainActivity extends ApplicationAdapter {

	activity_main view;
	FredAttributeDataStore fred;

	@Override
	public void create () {
		view = new activity_main();
		fred = new FredAttributeDataStore();
	}

	@Override
	//render() gets called every frame
	public void render () {
		//Clear screen
		Gdx.gl.glClearColor(1, 1, 0, 1);
		Gdx.gl.glClear(GL20.GL_COLOR_BUFFER_BIT);



		view.draw(fred);
	}
	
	@Override
	public void dispose () {
		view.dispose();
		fred.dispose();
	}
}
