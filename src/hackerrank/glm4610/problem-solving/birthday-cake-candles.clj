(defn ?-> [cond v l]
  (if cond (-> v l) v))

; Could be implemented with filter and count too
(defn tally [condf coll]
  (reduce #(?-> (condf %2) %1 inc) 0 coll))

(defn countTallest [coll]
  (let [tallest-val (apply max coll)
        is-tallest? #(= tallest-val %)]
    (tally is-tallest? coll)))

(countTallest '(1 2 3 4 4 3 3 4 1))
