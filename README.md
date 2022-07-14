# NLPExer
Exercises in Text mining and Natural Language Processing (NLP) mainly in Python

## Basic Notes
Check Capitalized words
```python
with open("example_text.txt", "r") as f:
    text = f.readlines()
    text2 = text.strip().split(" ")
    print([w for w in text2 if w.istitle()]) 
```
Conversion to titlecase
```
s.titlecase()
```