/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package clases;

/**
 *
 * @author Manue
 */
import java.time.LocalDateTime;

public class SupportTicket {
    private IssueType issueType;
    private TicketStatus status;
    private LocalDateTime createdAt;
    private Customer customer;

    public SupportTicket(IssueType issueType, Customer customer) {
        this.issueType = issueType;
        this.customer = customer;
        this.status = TicketStatus.OPEN;
        this.createdAt = LocalDateTime.now();
    }

    public void escalate() {
        this.status = TicketStatus.ESCALATED;
    }

    public void close() {
        this.status = TicketStatus.CLOSED;
    }

    public IssueType getIssueType() {
        return issueType;
    }

    public TicketStatus getStatus() {
        return status;
    }

    public LocalDateTime getCreatedAt() {
        return createdAt;
    }

    public Customer getCustomer() {
        return customer;
    }
}
