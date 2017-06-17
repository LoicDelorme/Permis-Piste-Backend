package fr.polytech.permispiste.services.impl;

import fr.polytech.permispiste.entities.Token;
import fr.polytech.permispiste.services.AbstractDaoServices;

/**
 * This class represents a token DAO services.
 *
 * @author DELORME Loïc
 * @since 1.0.0
 */
public class TokenDaoServices extends AbstractDaoServices<Token> {

	public TokenDaoServices() {
		super(Token.class);
	}

	@Override
	public String getTableName() {
		return "tokens";
	}
}