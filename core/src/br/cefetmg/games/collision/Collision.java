package br.cefetmg.games.collision;

import com.badlogic.gdx.math.Circle;
import com.badlogic.gdx.math.Rectangle;
import com.badlogic.gdx.math.Vector2;

/**
 * Utilitário para verificação de colisão.
 *
 * @author fegemo <coutinho@decom.cefetmg.br>
 */
public class Collision {

	/**
	 * Verifica se duas linhas se interceptam (considerando apenas uma dimensão).
	 * 
	 * @param begin1
	 *            A coordenada de início da primeira linha.
	 * @param len1
	 *            O comprimento da primeira linha.
	 * @param begin2
	 *            A coordenada de início da segunda linha.
	 * @param len2
	 *            O comprimento da segunda linha.
	 * @return true se as duas linhas se interceptam.
	 */
	public static final boolean linesOverlap(float begin1, float len1, float begin2, float len2) {
		return begin1 < begin2 + len2 && begin1 + len1 > begin2;
	}

	/**
	 * Verifica se dois círculos em 2D estão colidindo.
	 * 
	 * @param c1
	 *            círculo 1
	 * @param c2
	 *            círculo 2
	 * @return true se há colisão ou false, do contrário.
	 */
	public static final boolean circlesOverlap(Circle c1, Circle c2) {
		/*
		 * Este método não usa a implementação de overlaps da classe Circle
		 * propositalmente.
		 */
		float sumRadii = c1.radius + c2.radius;
		return Vector2.dst2(c1.x, c1.y, c2.x, c2.y) < sumRadii * sumRadii;
	}

	/**
	 * Verifica se dois retângulos em 2D estão colidindo. Esta função pode verificar
	 * se o eixo X dos dois objetos está colidindo e então se o mesmo ocorre com o
	 * eixo Y.
	 * 
	 * @param r1
	 *            retângulo 1
	 * @param r2
	 *            retângulo 2
	 * @return true se há colisão ou false, do contrário.
	 */
	public static final boolean rectsOverlap(Rectangle r1, Rectangle r2) {
		return linesOverlap(r1.x, r1.width, r2.x, r2.width) && linesOverlap(r1.y, r1.height, r2.y, r2.height);
	}
}
