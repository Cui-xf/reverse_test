package androidx.compose.runtime.collection;

import androidx.collection.ScatterSet;
import java.util.Set;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;

/* compiled from: ScatterSetWrapper.kt */
@Metadata(d1 = {"\u0000$\n\u0000\n\u0002\u0010\u000b\n\u0002\u0010\"\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\u001a'\u0010\u0000\u001a\u00020\u0001*\b\u0012\u0004\u0012\u00020\u00030\u00022\u0012\u0010\u0004\u001a\u000e\u0012\u0004\u0012\u00020\u0003\u0012\u0004\u0012\u00020\u00010\u0005H\u0080\b\u001a1\u0010\u0006\u001a\u00020\u0007\"\b\b\u0000\u0010\b*\u00020\u0003*\b\u0012\u0004\u0012\u0002H\b0\u00022\u0012\u0010\u0004\u001a\u000e\u0012\u0004\u0012\u0002H\b\u0012\u0004\u0012\u00020\u00070\u0005H\u0080\b\u001a\u001e\u0010\t\u001a\b\u0012\u0004\u0012\u0002H\b0\u0002\"\u0004\b\u0000\u0010\b*\b\u0012\u0004\u0012\u0002H\b0\nH\u0000¨\u0006\u000b"}, d2 = {"fastAny", "", "", "", "block", "Lkotlin/Function1;", "fastForEach", "", "T", "wrapIntoSet", "Landroidx/collection/ScatterSet;", "runtime_release"}, k = 2, mv = {1, 8, 0}, xi = 48)
/* loaded from: classes.dex */
public final class ScatterSetWrapperKt {
    public static final <T> Set<T> wrapIntoSet(ScatterSet<T> scatterSet) {
        return new ScatterSetWrapper(scatterSet);
    }

    public static final <T> void fastForEach(Set<? extends T> set, Function1<? super T, Unit> function1) {
        char c;
        int $i$f$fastForEach = 0;
        if (set instanceof ScatterSetWrapper) {
            ScatterSet this_$iv = ((ScatterSetWrapper) set).getSet$runtime_release();
            Object[] k$iv = this_$iv.elements;
            long[] m$iv$iv = this_$iv.metadata;
            int lastIndex$iv$iv = m$iv$iv.length - 2;
            int i$iv$iv = 0;
            if (0 > lastIndex$iv$iv) {
                return;
            }
            while (true) {
                long slot$iv$iv = m$iv$iv[i$iv$iv];
                int $i$f$fastForEach2 = $i$f$fastForEach;
                ScatterSet this_$iv2 = this_$iv;
                if ((((~slot$iv$iv) << 7) & slot$iv$iv & (-9187201950435737472L)) != -9187201950435737472L) {
                    int bitCount$iv$iv = 8 - ((~(i$iv$iv - lastIndex$iv$iv)) >>> 31);
                    for (int j$iv$iv = 0; j$iv$iv < bitCount$iv$iv; j$iv$iv++) {
                        long value$iv$iv$iv = 255 & slot$iv$iv;
                        if (!(value$iv$iv$iv < 128)) {
                            c = '\b';
                        } else {
                            int index$iv$iv = (i$iv$iv << 3) + j$iv$iv;
                            c = '\b';
                            function1.invoke(k$iv[index$iv$iv]);
                        }
                        slot$iv$iv >>= c;
                    }
                    if (bitCount$iv$iv != 8) {
                        return;
                    }
                }
                if (i$iv$iv == lastIndex$iv$iv) {
                    return;
                }
                i$iv$iv++;
                $i$f$fastForEach = $i$f$fastForEach2;
                this_$iv = this_$iv2;
            }
        } else {
            Set<? extends T> $this$forEach$iv = set;
            for (Object element$iv : $this$forEach$iv) {
                function1.invoke(element$iv);
            }
        }
    }

    /* JADX WARN: Removed duplicated region for block: B:23:0x0089  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public static final boolean fastAny(java.util.Set<? extends java.lang.Object> r24, kotlin.jvm.functions.Function1<java.lang.Object, java.lang.Boolean> r25) {
        /*
            Method dump skipped, instructions count: 205
            To view this dump change 'Code comments level' option to 'DEBUG'
        */
        throw new UnsupportedOperationException("Method not decompiled: androidx.compose.runtime.collection.ScatterSetWrapperKt.fastAny(java.util.Set, kotlin.jvm.functions.Function1):boolean");
    }
}
