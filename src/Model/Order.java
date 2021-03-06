package Model;

import Exceptions.OrderMutationException;
import Services.Entity.Entity;
import Utils.StrUtils;

import java.util.Date;

/**
 * Order class correspond to a client buying a car
 */
public class Order implements Entity, Dated {

    private int id;
    private statuses status;
    private Car car;
    private Builder builder;
    private Client client;
    private Date createdAt;
    private Date updatedAt;

    enum statuses {
        PENDING,
        PROCESSING,
        DONE,
        CANCELLED;

        statuses getNext() {
            return this.ordinal() < statuses.values().length - 1
                ? statuses.values()[this.ordinal() + 1]
                : null;
        }
    }

    /**
     * Default constructor, used by entityManager
     */
    public Order() {}

    public Order(Client client, Car car, Builder builder) {
        this.client = client;
        this.car = car;
        this.builder = builder;
        status = statuses.PENDING;
    }

    @Override
    public int getId() {
        return id;
    }

    @Override
    public Order setId(int id) {
        this.id = id;

        return this;
    }

    public statuses getStatus() {
        return status;
    }

    public void setStatus(statuses status) {
        this.status = status;
    }

    public Car getCar() {
        return car;
    }

    public void setCar(Car car) {
        this.car = car;
    }

    public Builder getBuilder() {
        return builder;
    }

    public void setBuilder(Builder builder) {
        this.builder = builder;
    }

    public Client getClient() {
        return client;
    }

    public void setClient(Client client) {
        this.client = client;
    }

    public Date getCreatedAt() {
        return createdAt;
    }

    public void setCreatedAt() {
        this.createdAt = new Date();
    }

    public Date getUpdatedAt() {
        return updatedAt;
    }

    public void setUpdatedAt() {
        this.updatedAt = new Date();;
    }

    /**
     * Pass to next order status, DONE order is last one
     *
     * @throws OrderMutationException
     */
    public void nextStatus() throws OrderMutationException {
        if (status == statuses.DONE || status == statuses.CANCELLED) {
            throw new OrderMutationException();
        }
        status = status.getNext();
        this.builder.decrementUsedCapacity();
        this.setUpdatedAt();
    }

    /**
     * Cancel an order
     *
     * @throws OrderMutationException
     */
    public void cancel() throws OrderMutationException {
        if (status == statuses.DONE) {
            throw new OrderMutationException();
        }
        status = statuses.CANCELLED;
        this.builder.decrementUsedCapacity();
        this.setUpdatedAt();
    }

    @Override
    public String toString(boolean list) {
        return id +
            ", " + status +
            ", " + client.toString() +
            ", " + car.getBrandName() +
            ", " + car.getModelName() +
            ", " + builder.getName() +
            ", " + StrUtils.dateFmt(createdAt) +
            ", " + StrUtils.dateFmt(updatedAt);
    }

    @Override
    public String toString() {
        return id +
            ", " + client.toString() +
            ", " + car.getModelName() +
            ", " + builder.getName();
    }
}
