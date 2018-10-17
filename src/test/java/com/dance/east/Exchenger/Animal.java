package com.dance.east.Exchenger;

public enum Animal {
    A{
        @Override
        public void a() {

        }

        @Override
        public void b() {

        }
    },B{
        @Override
        public void a() {

        }

        @Override
        public void b() {

        }
    };

    Animal() {
        System.out.println("AA构造");
    }

    public final void excute(){
        a();
        b();
    }

    protected abstract void a();
    protected abstract void b();

}
