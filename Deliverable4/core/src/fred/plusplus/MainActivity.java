package fred.plusplus;

import com.badlogic.gdx.ApplicationAdapter;
import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.graphics.GL20;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;

public class MainActivity extends ApplicationAdapter {
	SpriteBatch batch;
	Texture fredBase;
	Texture skeleton;


	@Override
	public void create () {
		batch = new SpriteBatch();
		fredBase = new Texture("FredBaseTemplate.png");
		skeleton = new Texture("FredSkeleton.png");

	}

	@Override
	public void render () {
		Gdx.gl.glClearColor(1, 1, 0, 1);
		Gdx.gl.glClear(GL20.GL_COLOR_BUFFER_BIT);
		batch.begin();
		batch.draw(fredBase, 0, 0);
		batch.draw(skeleton, 0, 0);

		batch.end();
	}
	
	@Override
	public void dispose () {
		batch.dispose();
		fredBase.dispose();
		skeleton.dispose();
	}
}
