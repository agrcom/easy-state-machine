import lombok.extern.java.Log;

@Log
public enum TicketState {

    initial {
        private Ticket ticket;

        @Override
        public TicketState nextState() {
            open.setTicket(ticket);
            return TicketState.open;
        }

        @Override
        void setTicket(Ticket ticket) {
            this.ticket = ticket;
        }

        @Override
        Ticket getTicket() {
            return this.ticket;
        }

        @Override
        void proceed() {
            this.ticket.setStatus(open);
        }
    },

    open {
        private Ticket ticket;

        @Override
        public TicketState nextState() {
            inDevelopment.setTicket(ticket);

            if (ticket.getStatus().equals(TicketState.inDevelopment)) {
                return inDevelopment;
            } else return this;
        }

        void setTicket(Ticket ticket) {
            this.ticket = ticket;
        }

        @Override
        Ticket getTicket() {
            return ticket;
        }

        @Override
        void proceed() {
            this.ticket.setStatus(inDevelopment);
        }
    },
    inDevelopment {
        private Ticket ticket;

        @Override
        TicketState nextState() {
            close.setTicket(ticket);
            return TicketState.close;
        }

        @Override
        void setTicket(Ticket ticket) {
            this.ticket = ticket;
        }

        @Override
        Ticket getTicket() {
            return ticket;
        }

        @Override
        void proceed() {
            this.ticket.setStatus(close);
        }
    },

    close {
        private Ticket ticket;

        @Override
        TicketState nextState() {
            return this;
        }

        @Override
        void setTicket(Ticket ticket) {
            this.ticket = ticket;
        }

        @Override
        Ticket getTicket() {
            return this.ticket;
        }

        @Override
        void proceed() {
            this.ticket.setStatus(this);
        }
    };


    abstract TicketState nextState();

    abstract void setTicket(Ticket ticket);

    abstract Ticket getTicket();

    abstract void proceed();


}
