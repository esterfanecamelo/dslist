package com.devsuperior.dslist.entities;

import jakarta.persistence.Embeddable;
import jakarta.persistence.EmbeddedId;
import jakarta.persistence.Entity;
import jakarta.persistence.Table;

@Entity
@Table(name = "tb_belonging")
public class Belonging {

    @EmbeddedId
    private BelongingPK id = new BelongingPK();

    private Integer position;

    public Belonging(){}

    public Belonging(Game game, GameList gameList, Integer position){
        id.setGame(game);
        id.setList(gameList);
        this.position = position;
    }

    public BelongingPK getId(){
        return id;
    }
    public void setId(BelongingPK id){
        this.id = id;
    }
    public Integer getPosition(){
        return position;
    }
    public void setPosition(Integer position){
        this.position = position;
    }

    @Override
    public int hashCode(){
        return id.hashCode();
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj){
            return true;
        }
        if (obj == null){
            return false;
        }
        if (!(obj instanceof Belonging)){
            return false;
        }
        Belonging other = (Belonging) obj;
        return id.equals(other.id);

    }
}
