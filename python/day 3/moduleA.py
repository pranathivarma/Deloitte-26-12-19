#!/usr/bin/env python
# coding: utf-8

# In[1]:


# creating a module


# In[2]:


def name():
    print("I am a module")


# In[3]:


a = 130
b = 25
def sumab():
    global a,b
    print("The sum of a,b is: ",(a+b))


# In[4]:


__name__


# In[18]:


if __name__ != "__main__":
    def showr():
        print("I am inside a module")


# In[20]:


show()


# In[21]:


showr()


# In[22]:


if __name__ == "__moduleA__":
    def newShow():
        print("ModuleA is accessed")


# In[ ]:




