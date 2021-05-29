for f in *; do
	if [ -d $f ]; then
		cd $f
		mkdir Input
		for e in *.in; do
			[ -f "$e" ] || break
			mv $e ./Input
		done 
		cd Input
		touch .keep
		cd ..
		mkdir Output
		for e in *.out; do
                        [ -f "$e" ] || break
                        mv $e ./Output
                done
		cd Output
		touch .keep
		cd ..
		cd ..
	fi
done
