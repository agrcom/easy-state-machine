public class Ticket {
    /*
     * https://cleanjava.wordpress.com/2012/02/25/enum-as-state-machine/
     */

    enum State {
        INITIAL {
            void proceed(Ticket ticket) {
                ticket.state = OPEN;
            }
        },
        OPEN {
            void proceed(Ticket ticket) {
                ticket.state = IN_DEVELOPMENT;
            }
        },
        IN_DEVELOPMENT {
            void proceed(Ticket ticket) {
                ticket.state = CLOSED;
            }
        },
        CLOSED {
            void proceed(Ticket ticket) {

            }
        };

        abstract void proceed(Ticket ticket);
    }

    private State state = State.INITIAL;

    public State getState() {
        return state;
    }

    public void setState(State state) {
        this.state = state;
    }

    public void proceed() {
        this.state.proceed(this);
    }

}



/*
* public class Entity {




package org.sanju.worflow;

public class EntityClient {

    public static void main(String[] args) {

        Entity entity = new Entity();
        System.out.println(entity.getState());
        entity.proceed();
        System.out.println(entity.getState());
        entity.proceed();
        System.out.println(entity.getState());
        entity.proceed();
        System.out.println(entity.getState());
    }

}
*
* */