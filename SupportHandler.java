interface SupportHandler {
    void handleRequest(SupportTicket ticket);
}

class BasicSupportHandler implements SupportHandler {
    private SupportHandler nextHandler;

    @Override
    public void handleRequest(SupportTicket ticket) {
        if (ticket.getPriority() == Priority.BASIC) {
            System.out.println("Basic support team is handling ticket: " + ticket);
        } else if (nextHandler != null) {
            nextHandler.handleRequest(ticket);
        } else {
            System.out.println("No handler available to handle ticket: " + ticket);
        }
    }

    public void setNextHandler(SupportHandler nextHandler) {
        this.nextHandler = nextHandler;
    }
}

class IntermediateSupportHandler implements SupportHandler {
    private SupportHandler nextHandler;

    @Override
    public void handleRequest(SupportTicket ticket) {
        if (ticket.getPriority() == Priority.INTERMEDIATE) {
            System.out.println("Intermediate support team is handling ticket: " + ticket);
        } else if (nextHandler != null) {
            nextHandler.handleRequest(ticket);
        } else {
            System.out.println("No handler available to handle ticket: " + ticket);
        }
    }

    public void setNextHandler(SupportHandler nextHandler) {
        this.nextHandler = nextHandler;
    }
}

class AdvancedSupportHandler implements SupportHandler {
    private SupportHandler nextHandler;

    @Override
    public void handleRequest(SupportTicket ticket) {
        if (ticket.getPriority() == Priority.ADVANCED) {
            System.out.println("Advanced support team is handling ticket: " + ticket);
        } else if (nextHandler != null) {
            nextHandler.handleRequest(ticket);
        } else {
            System.out.println("No handler available to handle ticket: " + ticket);
        }
    }

    public void setNextHandler(SupportHandler nextHandler) {
        this.nextHandler = nextHandler;
    }
}

class SupportTicket {
    private int id;
    private String description;
    private Priority priority;

    public SupportTicket(int id, String description, Priority priority) {
        this.id = id;
        this.description = description;
        this.priority = priority;
    }

    public int getId() {
        return id;
    }

    public String getDescription() {
        return description;
    }

    public Priority getPriority() {
        return priority;
    }

    @Override
    public String toString() {
        return "SupportTicket{" +
                "id=" + id +
                ", description='" + description + '\'' +
                ", priority=" + priority +
                '}';
    }
}

enum Priority {
    BASIC,
    INTERMEDIATE,
    ADVANCED
}

class Test7 {
    public static void main(String[] args) {
        BasicSupportHandler basicHandler = new BasicSupportHandler();
        IntermediateSupportHandler intermediateHandler = new IntermediateSupportHandler();
        AdvancedSupportHandler advancedHandler = new AdvancedSupportHandler();

        basicHandler.setNextHandler(intermediateHandler);
        intermediateHandler.setNextHandler(advancedHandler);

        SupportTicket ticket1 = new SupportTicket(1, "Network issue", Priority.BASIC);
        SupportTicket ticket2 = new SupportTicket(2, "Software problem", Priority.INTERMEDIATE);
        SupportTicket ticket3 = new SupportTicket(3, "Hardware malfunction", Priority.ADVANCED);
        SupportTicket ticket4 = new SupportTicket(4, "Printer not working", Priority.BASIC);

        basicHandler.handleRequest(ticket1);
        basicHandler.handleRequest(ticket2);
        basicHandler.handleRequest(ticket3);
        basicHandler.handleRequest(ticket4);
    }
}

