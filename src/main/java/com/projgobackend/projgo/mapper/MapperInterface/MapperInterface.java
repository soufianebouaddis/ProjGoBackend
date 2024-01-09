package com.projgobackend.projgo.mapper.MapperInterface;

public interface MapperInterface<A, B> {
    public B mapToEntity(A o);

    public A mapFromEntity(B o);
}
